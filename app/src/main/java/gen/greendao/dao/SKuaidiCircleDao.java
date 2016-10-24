package gen.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import gen.greendao.bean.SKuaidiCircle;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SKUAIDI_CIRCLE".
*/
public class SKuaidiCircleDao extends AbstractDao<SKuaidiCircle, String> {

    public static final String TABLENAME = "SKUAIDI_CIRCLE";

    /**
     * Properties of entity SKuaidiCircle.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Wduser_id = new Property(1, String.class, "wduser_id", false, "WDUSER_ID");
        public final static Property Shop = new Property(2, String.class, "shop", false, "SHOP");
        public final static Property Brand = new Property(3, String.class, "brand", false, "BRAND");
        public final static Property County = new Property(4, String.class, "county", false, "COUNTY");
        public final static Property Address = new Property(5, String.class, "address", false, "ADDRESS");
        public final static Property Content = new Property(6, String.class, "content", false, "CONTENT");
        public final static Property Update_time = new Property(7, String.class, "update_time", false, "UPDATE_TIME");
        public final static Property Channel = new Property(8, String.class, "channel", false, "CHANNEL");
        public final static Property Lat = new Property(9, String.class, "lat", false, "LAT");
        public final static Property Lng = new Property(10, String.class, "lng", false, "LNG");
        public final static Property Hash = new Property(11, String.class, "hash", false, "HASH");
        public final static Property Pic = new Property(12, String.class, "pic", false, "PIC");
        public final static Property Huifu = new Property(13, String.class, "huifu", false, "HUIFU");
        public final static Property Good = new Property(14, String.class, "good", false, "GOOD");
        public final static Property Fenxiang = new Property(15, String.class, "fenxiang", false, "FENXIANG");
        public final static Property Hot = new Property(16, String.class, "hot", false, "HOT");
        public final static Property Top = new Property(17, String.class, "top", false, "TOP");
        public final static Property Is_good = new Property(18, boolean.class, "is_good", false, "IS_GOOD");
        public final static Property Message = new Property(19, String.class, "message", false, "MESSAGE");
        public final static Property Imageurls = new Property(20, String.class, "imageurls", false, "IMAGEURLS");
        public final static Property Imageurlsbig = new Property(21, String.class, "imageurlsbig", false, "IMAGEURLSBIG");
    }


    public SKuaidiCircleDao(DaoConfig config) {
        super(config);
    }
    
    public SKuaidiCircleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SKUAIDI_CIRCLE\" (" + //
                "\"ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "\"WDUSER_ID\" TEXT," + // 1: wduser_id
                "\"SHOP\" TEXT," + // 2: shop
                "\"BRAND\" TEXT," + // 3: brand
                "\"COUNTY\" TEXT," + // 4: county
                "\"ADDRESS\" TEXT," + // 5: address
                "\"CONTENT\" TEXT," + // 6: content
                "\"UPDATE_TIME\" TEXT," + // 7: update_time
                "\"CHANNEL\" TEXT," + // 8: channel
                "\"LAT\" TEXT," + // 9: lat
                "\"LNG\" TEXT," + // 10: lng
                "\"HASH\" TEXT," + // 11: hash
                "\"PIC\" TEXT," + // 12: pic
                "\"HUIFU\" TEXT," + // 13: huifu
                "\"GOOD\" TEXT," + // 14: good
                "\"FENXIANG\" TEXT," + // 15: fenxiang
                "\"HOT\" TEXT," + // 16: hot
                "\"TOP\" TEXT," + // 17: top
                "\"IS_GOOD\" INTEGER NOT NULL ," + // 18: is_good
                "\"MESSAGE\" TEXT," + // 19: message
                "\"IMAGEURLS\" TEXT," + // 20: imageurls
                "\"IMAGEURLSBIG\" TEXT);"); // 21: imageurlsbig
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_SKUAIDI_CIRCLE_ID ON SKUAIDI_CIRCLE" +
                " (\"ID\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SKUAIDI_CIRCLE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SKuaidiCircle entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getId());
 
        String wduser_id = entity.getWduser_id();
        if (wduser_id != null) {
            stmt.bindString(2, wduser_id);
        }
 
        String shop = entity.getShop();
        if (shop != null) {
            stmt.bindString(3, shop);
        }
 
        String brand = entity.getBrand();
        if (brand != null) {
            stmt.bindString(4, brand);
        }
 
        String county = entity.getCounty();
        if (county != null) {
            stmt.bindString(5, county);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(7, content);
        }
 
        String update_time = entity.getUpdate_time();
        if (update_time != null) {
            stmt.bindString(8, update_time);
        }
 
        String channel = entity.getChannel();
        if (channel != null) {
            stmt.bindString(9, channel);
        }
 
        String lat = entity.getLat();
        if (lat != null) {
            stmt.bindString(10, lat);
        }
 
        String lng = entity.getLng();
        if (lng != null) {
            stmt.bindString(11, lng);
        }
 
        String hash = entity.getHash();
        if (hash != null) {
            stmt.bindString(12, hash);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(13, pic);
        }
 
        String huifu = entity.getHuifu();
        if (huifu != null) {
            stmt.bindString(14, huifu);
        }
 
        String good = entity.getGood();
        if (good != null) {
            stmt.bindString(15, good);
        }
 
        String fenxiang = entity.getFenxiang();
        if (fenxiang != null) {
            stmt.bindString(16, fenxiang);
        }
 
        String hot = entity.getHot();
        if (hot != null) {
            stmt.bindString(17, hot);
        }
 
        String top = entity.getTop();
        if (top != null) {
            stmt.bindString(18, top);
        }
        stmt.bindLong(19, entity.getIs_good() ? 1L: 0L);
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(20, message);
        }
 
        String imageurls = entity.getImageurls();
        if (imageurls != null) {
            stmt.bindString(21, imageurls);
        }
 
        String imageurlsbig = entity.getImageurlsbig();
        if (imageurlsbig != null) {
            stmt.bindString(22, imageurlsbig);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SKuaidiCircle entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getId());
 
        String wduser_id = entity.getWduser_id();
        if (wduser_id != null) {
            stmt.bindString(2, wduser_id);
        }
 
        String shop = entity.getShop();
        if (shop != null) {
            stmt.bindString(3, shop);
        }
 
        String brand = entity.getBrand();
        if (brand != null) {
            stmt.bindString(4, brand);
        }
 
        String county = entity.getCounty();
        if (county != null) {
            stmt.bindString(5, county);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(6, address);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(7, content);
        }
 
        String update_time = entity.getUpdate_time();
        if (update_time != null) {
            stmt.bindString(8, update_time);
        }
 
        String channel = entity.getChannel();
        if (channel != null) {
            stmt.bindString(9, channel);
        }
 
        String lat = entity.getLat();
        if (lat != null) {
            stmt.bindString(10, lat);
        }
 
        String lng = entity.getLng();
        if (lng != null) {
            stmt.bindString(11, lng);
        }
 
        String hash = entity.getHash();
        if (hash != null) {
            stmt.bindString(12, hash);
        }
 
        String pic = entity.getPic();
        if (pic != null) {
            stmt.bindString(13, pic);
        }
 
        String huifu = entity.getHuifu();
        if (huifu != null) {
            stmt.bindString(14, huifu);
        }
 
        String good = entity.getGood();
        if (good != null) {
            stmt.bindString(15, good);
        }
 
        String fenxiang = entity.getFenxiang();
        if (fenxiang != null) {
            stmt.bindString(16, fenxiang);
        }
 
        String hot = entity.getHot();
        if (hot != null) {
            stmt.bindString(17, hot);
        }
 
        String top = entity.getTop();
        if (top != null) {
            stmt.bindString(18, top);
        }
        stmt.bindLong(19, entity.getIs_good() ? 1L: 0L);
 
        String message = entity.getMessage();
        if (message != null) {
            stmt.bindString(20, message);
        }
 
        String imageurls = entity.getImageurls();
        if (imageurls != null) {
            stmt.bindString(21, imageurls);
        }
 
        String imageurlsbig = entity.getImageurlsbig();
        if (imageurlsbig != null) {
            stmt.bindString(22, imageurlsbig);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    @Override
    public SKuaidiCircle readEntity(Cursor cursor, int offset) {
        SKuaidiCircle entity = new SKuaidiCircle( //
            cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // wduser_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // shop
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // brand
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // county
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // address
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // content
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // update_time
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // channel
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // lat
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // lng
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // hash
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // pic
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // huifu
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // good
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // fenxiang
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // hot
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // top
            cursor.getShort(offset + 18) != 0, // is_good
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // message
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // imageurls
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21) // imageurlsbig
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SKuaidiCircle entity, int offset) {
        entity.setId(cursor.getString(offset + 0));
        entity.setWduser_id(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setShop(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setBrand(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCounty(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAddress(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setContent(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUpdate_time(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setChannel(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setLat(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setLng(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setHash(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setPic(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setHuifu(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setGood(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setFenxiang(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setHot(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setTop(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setIs_good(cursor.getShort(offset + 18) != 0);
        entity.setMessage(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setImageurls(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setImageurlsbig(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
     }
    
    @Override
    protected final String updateKeyAfterInsert(SKuaidiCircle entity, long rowId) {
        return entity.getId();
    }
    
    @Override
    public String getKey(SKuaidiCircle entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(SKuaidiCircle entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}