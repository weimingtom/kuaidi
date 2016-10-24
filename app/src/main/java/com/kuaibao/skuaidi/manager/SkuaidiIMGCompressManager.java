package com.kuaibao.skuaidi.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.kuaibao.skuaidi.application.SKuaidiApplication;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class SkuaidiIMGCompressManager {
	private final static Context context = SKuaidiApplication.getInstance();
	
	private static int getResizedDimension(int maxPrimary, int maxSecondary,
			int actualPrimary, int actualSecondary) {
		// If no dominant value at all, just return the actual.
		if (maxPrimary == 0 && maxSecondary == 0) {
			return actualPrimary;
		}

		// If primary is unspecified, scale primary to match secondary's scaling
		// ratio.
		if (maxPrimary == 0) {
			double ratio = (double) maxSecondary / (double) actualSecondary;
			return (int) (actualPrimary * ratio);
		}

		if (maxSecondary == 0) {
			return maxPrimary;
		}

		double ratio = (double) actualSecondary / (double) actualPrimary;
		int resized = maxPrimary;
		if (resized * ratio > maxSecondary) {
			resized = (int) (maxSecondary / ratio);
		}
		return resized;
	}

	private static int findBestSampleSize(int actualWidth, int actualHeight,
			int desiredWidth, int desiredHeight) {
		double wr = (double) actualWidth / desiredWidth;
		double hr = (double) actualHeight / desiredHeight;
		double ratio = Math.min(wr, hr);
		float n = 1.0f;
		while ((n * 2) <= ratio) {
			n *= 2;
		}

		return (int) n;
	}
	
	/**
	 * 根据文件名获取压缩图片
	 * @param fileName
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromAssetsFile(String fileName, int mMaxWidth,
			int mMaxHeight) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		Bitmap bitmap = null;
		Config preferredConfig = Config.RGB_565;
		AssetManager am = context.getResources().getAssets();
		try {
			if (mMaxWidth == 0 && mMaxHeight == 0) {
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = am.open(fileName);
				bitmap = BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
			} else {
				// If we have to resize this image, first get the natural
				// bounds.
				decodeOptions.inJustDecodeBounds = true;
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = am.open(fileName);
				BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
				int actualWidth = decodeOptions.outWidth;
				int actualHeight = decodeOptions.outHeight;

				// Then compute the dimensions we would ideally like to decode
				// to.
				int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
						actualWidth, actualHeight);
				int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
						actualHeight, actualWidth);

				// Decode to the nearest power of two scaling factor.
				decodeOptions.inJustDecodeBounds = false;
				// TODO(ficus): Do we need this or is it okay since API 8
				// doesn't
				// support it?
				// decodeOptions.inPreferQualityOverSpeed =
				// PREFER_QUALITY_OVER_SPEED;
				decodeOptions.inSampleSize = findBestSampleSize(actualWidth,
						actualHeight, desiredWidth, desiredHeight);
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is2 = am.open(fileName);
				Bitmap tempBitmap = BitmapFactory.decodeStream(is2, null,
						decodeOptions);
				is2.close();
				// If necessary, scale down to the maximal acceptable size.
				if (tempBitmap != null
						&& (tempBitmap.getWidth() > desiredWidth || tempBitmap
								.getHeight() > desiredHeight)) {
					bitmap = Bitmap.createScaledBitmap(tempBitmap,
							desiredWidth, desiredHeight, true);
					tempBitmap.recycle();
				} else {
					bitmap = tempBitmap;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
	
	/**
	 * 根据Byte[]获取压缩图片
	 * @param data
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromData(byte[] data, int mMaxWidth,
			int mMaxHeight) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		Bitmap bitmap = null;
		if (mMaxWidth == 0 && mMaxHeight == 0) {
			decodeOptions.inPreferredConfig = Config.RGB_565;
			bitmap = BitmapFactory.decodeByteArray(data, 0, data.length,
					decodeOptions);
		} else {
			// If we have to resize this image, first get the natural bounds.
			decodeOptions.inJustDecodeBounds = true;
			BitmapFactory.decodeByteArray(data, 0, data.length, decodeOptions);
			int actualWidth = decodeOptions.outWidth;
			int actualHeight = decodeOptions.outHeight;

			// Then compute the dimensions we would ideally like to decode to.
			int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
					actualWidth, actualHeight);
			int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
					actualHeight, actualWidth);

			// Decode to the nearest power of two scaling factor.
			decodeOptions.inJustDecodeBounds = false;
			// TODO(ficus): Do we need this or is it okay since API 8 doesn't
			// support it?
			// decodeOptions.inPreferQualityOverSpeed =
			// PREFER_QUALITY_OVER_SPEED;
			decodeOptions.inSampleSize = findBestSampleSize(actualWidth,
					actualHeight, desiredWidth, desiredHeight);
			Bitmap tempBitmap = BitmapFactory.decodeByteArray(data, 0,
					data.length, decodeOptions);

			// If necessary, scale down to the maximal acceptable size.
			if (tempBitmap != null
					&& (tempBitmap.getWidth() > desiredWidth || tempBitmap
							.getHeight() > desiredHeight)) {
				bitmap = Bitmap.createScaledBitmap(tempBitmap, desiredWidth,
						desiredHeight, true);
				tempBitmap.recycle();
			} else {
				bitmap = tempBitmap;
			}
		}
		return bitmap;
	}
	
	/**
	 * 根据BitMap获取压缩图片
	 * @param srcBitmap
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromBitmap(Bitmap srcBitmap, int mMaxWidth,
			int mMaxHeight) {
		Bitmap bitmap = null;
		if (mMaxWidth == 0 && mMaxHeight == 0) {
			bitmap = srcBitmap;
		} else {
			int actualWidth = srcBitmap.getWidth();
			int actualHeight = srcBitmap.getHeight();

			// Then compute the dimensions we would ideally like to decode to.
			int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
					actualWidth, actualHeight);
			int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
					actualHeight, actualWidth);
			bitmap = Bitmap.createScaledBitmap(srcBitmap, desiredWidth,
					desiredHeight, true);
		}
		return bitmap;
	}
	
	/**
	 * 根据URI获取压缩图片
	 * @param uri
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromUri(Uri uri, int mMaxWidth, int mMaxHeight) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		Bitmap bitmap = null;
		Config preferredConfig = Config.RGB_565;
		try {
			if (mMaxWidth == 0 && mMaxHeight == 0) {
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = context.getContentResolver()
						.openInputStream(uri);
				bitmap = BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
			} else {
				// If we have to resize this image, first get the natural
				// bounds.
				decodeOptions.inJustDecodeBounds = true;
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = context.getContentResolver()
						.openInputStream(uri);
				BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
				int actualWidth = decodeOptions.outWidth;
				int actualHeight = decodeOptions.outHeight;

				// Then compute the dimensions we would ideally like to decode
				// to.
				int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
						actualWidth, actualHeight);
				int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
						actualHeight, actualWidth);

				// Decode to the nearest power of two scaling factor.
				decodeOptions.inJustDecodeBounds = false;
				// TODO(ficus): Do we need this or is it okay since API 8
				// doesn't
				// support it?
				// decodeOptions.inPreferQualityOverSpeed =
				// PREFER_QUALITY_OVER_SPEED;
				decodeOptions.inSampleSize = findBestSampleSize(actualWidth,
						actualHeight, desiredWidth, desiredHeight);
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is2 = context.getContentResolver()
						.openInputStream(uri);
				Bitmap tempBitmap = BitmapFactory.decodeStream(is2, null,
						decodeOptions);
				is2.close();
				// If necessary, scale down to the maximal acceptable size.
				if (tempBitmap != null
						&& (tempBitmap.getWidth() > desiredWidth || tempBitmap
								.getHeight() > desiredHeight)) {
					bitmap = Bitmap.createScaledBitmap(tempBitmap,
							desiredWidth, desiredHeight, true);
					tempBitmap.recycle();
				} else {
					bitmap = tempBitmap;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
	
	/**
	 * 根据资源ID获取压缩图片
	 * @param resId
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromResource(int resId, int mMaxWidth,
			int mMaxHeight) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		Bitmap bitmap = null;
		Config preferredConfig = Config.RGB_565;
		try {
			if (mMaxWidth == 0 && mMaxHeight == 0) {
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = context.getResources().openRawResource(
						resId);
				bitmap = BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
			} else {
				// If we have to resize this image, first get the natural
				// bounds.
				decodeOptions.inJustDecodeBounds = true;
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is = context.getResources().openRawResource(
						resId);
				BitmapFactory.decodeStream(is, null, decodeOptions);
				is.close();
				int actualWidth = decodeOptions.outWidth;
				int actualHeight = decodeOptions.outHeight;

				// Then compute the dimensions we would ideally like to decode
				// to.
				int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
						actualWidth, actualHeight);
				int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
						actualHeight, actualWidth);

				// Decode to the nearest power of two scaling factor.
				decodeOptions.inJustDecodeBounds = false;
				// TODO(ficus): Do we need this or is it okay since API 8
				// doesn't
				// support it?
				// decodeOptions.inPreferQualityOverSpeed =
				// PREFER_QUALITY_OVER_SPEED;
				decodeOptions.inSampleSize = findBestSampleSize(actualWidth,
						actualHeight, desiredWidth, desiredHeight);
				decodeOptions.inPreferredConfig = preferredConfig;
				InputStream is2 = context.getResources()
						.openRawResource(resId);
				Bitmap tempBitmap = BitmapFactory.decodeStream(is2, null,
						decodeOptions);
				is2.close();
				// If necessary, scale down to the maximal acceptable size.
				if (tempBitmap != null
						&& (tempBitmap.getWidth() > desiredWidth || tempBitmap
								.getHeight() > desiredHeight)) {
					bitmap = Bitmap.createScaledBitmap(tempBitmap,
							desiredWidth, desiredHeight, true);
					tempBitmap.recycle();
				} else {
					bitmap = tempBitmap;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}
	
	/**
	 * 根据文件获取压缩图片
	 * @param file
	 * @param mMaxWidth
	 * @param mMaxHeight
	 * @return
	 */
	public static Bitmap getImageFromFile(File file, int mMaxWidth,
			int mMaxHeight) {
		BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
		Bitmap bitmap = null;
		Config preferredConfig = Config.RGB_565;
		try {
			if (mMaxWidth == 0 && mMaxHeight == 0) {
				bitmap = BitmapFactory.decodeFile(file.getPath());
			} else {
				// If we have to resize this image, first get the natural
				// bounds.
				decodeOptions.inJustDecodeBounds = true;
				decodeOptions.inPreferredConfig = preferredConfig;
				bitmap = BitmapFactory
						.decodeFile(file.getPath(), decodeOptions);
				int actualWidth = decodeOptions.outWidth;
				int actualHeight = decodeOptions.outHeight;

				// Then compute the dimensions we would ideally like to decode
				// to.
				int desiredWidth = getResizedDimension(mMaxWidth, mMaxHeight,
						actualWidth, actualHeight);
				int desiredHeight = getResizedDimension(mMaxHeight, mMaxWidth,
						actualHeight, actualWidth);

				// Decode to the nearest power of two scaling factor.
				decodeOptions.inJustDecodeBounds = false;
				// TODO(ficus): Do we need this or is it okay since API 8
				// doesn't
				// support it?
				// decodeOptions.inPreferQualityOverSpeed =
				// PREFER_QUALITY_OVER_SPEED;
				decodeOptions.inSampleSize = findBestSampleSize(actualWidth,
						actualHeight, desiredWidth, desiredHeight);
				decodeOptions.inPreferredConfig = preferredConfig;
				Bitmap tempBitmap = BitmapFactory.decodeFile(file.getPath(),
						decodeOptions);
				// If necessary, scale down to the maximal acceptable size.
				if (tempBitmap != null
						&& (tempBitmap.getWidth() > desiredWidth || tempBitmap
								.getHeight() > desiredHeight)) {
					bitmap = Bitmap.createScaledBitmap(tempBitmap,
							desiredWidth, desiredHeight, true);
					tempBitmap.recycle();
				} else {
					bitmap = tempBitmap;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;
	}
}
