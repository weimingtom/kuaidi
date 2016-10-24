package gen.greendao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import gen.greendao.bean.Dispatch;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DISPATCH".
*/
public class DispatchDao extends AbstractDao<Dispatch, String> {

    public static final String TABLENAME = "DISPATCH";

    /**
     * Properties of entity Dispatch.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property WayBillNo = new Property(0, String.class, "wayBillNo", true, "WAY_BILL_NO");
        public final static Property WayBillTime = new Property(1, String.class, "wayBillTime", false, "WAY_BILL_TIME");
        public final static Property Status = new Property(2, String.class, "status", false, "STATUS");
        public final static Property CourierNO = new Property(3, String.class, "courierNO", false, "COURIER_NO");
        public final static Property Address = new Property(4, String.class, "address", false, "ADDRESS");
        public final static Property IsSelected = new Property(5, Boolean.class, "isSelected", false, "IS_SELECTED");
        public final static Property IsDeleted = new Property(6, Boolean.class, "isDeleted", false, "IS_DELETED");
        public final static Property Notes = new Property(7, String.class, "notes", false, "NOTES");
        public final static Property NoticeUpdateTime = new Property(8, String.class, "noticeUpdateTime", false, "NOTICE_UPDATE_TIME");
        public final static Property IsShow = new Property(9, Integer.class, "isShow", false, "IS_SHOW");
        public final static Property Province = new Property(10, String.class, "province", false, "PROVINCE");
        public final static Property City = new Property(11, String.class, "city", false, "CITY");
        public final static Property Area = new Property(12, String.class, "area", false, "AREA");
        public final static Property Latitude = new Property(13, double.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(14, double.class, "longitude", false, "LONGITUDE");
        public final static Property Name = new Property(15, String.class, "name", false, "NAME");
        public final static Property Mobile = new Property(16, String.class, "mobile", false, "MOBILE");
    }


    public DispatchDao(DaoConfig config) {
        super(config);
    }
    
    public DispatchDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DISPATCH\" (" + //
                "\"WAY_BILL_NO\" TEXT PRIMARY KEY NOT NULL ," + // 0: wayBillNo
                "\"WAY_BILL_TIME\" TEXT," + // 1: wayBillTime
                "\"STATUS\" TEXT," + // 2: status
                "\"COURIER_NO\" TEXT NOT NULL ," + // 3: courierNO
                "\"ADDRESS\" TEXT," + // 4: address
                "\"IS_SELECTED\" INTEGER," + // 5: isSelected
                "\"IS_DELETED\" INTEGER," + // 6: isDeleted
                "\"NOTES\" TEXT," + // 7: notes
                "\"NOTICE_UPDATE_TIME\" TEXT," + // 8: noticeUpdateTime
                "\"IS_SHOW\" INTEGER," + // 9: isShow
                "\"PROVINCE\" TEXT," + // 10: province
                "\"CITY\" TEXT," + // 11: city
                "\"AREA\" TEXT," + // 12: area
                "\"LATITUDE\" REAL NOT NULL ," + // 13: latitude
                "\"LONGITUDE\" REAL NOT NULL ," + // 14: longitude
                "\"NAME\" TEXT," + // 15: name
                "\"MOBILE\" TEXT);"); // 16: mobile
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_DISPATCH_WAY_BILL_NO ON DISPATCH" +
                " (\"WAY_BILL_NO\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DISPATCH\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Dispatch entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getWayBillNo());
 
        String wayBillTime = entity.getWayBillTime();
        if (wayBillTime != null) {
            stmt.bindString(2, wayBillTime);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(3, status);
        }
        stmt.bindString(4, entity.getCourierNO());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        Boolean isSelected = entity.getIsSelected();
        if (isSelected != null) {
            stmt.bindLong(6, isSelected ? 1L: 0L);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(7, isDeleted ? 1L: 0L);
        }
 
        String notes = entity.getNotes();
        if (notes != null) {
            stmt.bindString(8, notes);
        }
 
        String noticeUpdateTime = entity.getNoticeUpdateTime();
        if (noticeUpdateTime != null) {
            stmt.bindString(9, noticeUpdateTime);
        }
 
        Integer isShow = entity.getIsShow();
        if (isShow != null) {
            stmt.bindLong(10, isShow);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(11, province);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(12, city);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(13, area);
        }
        stmt.bindDouble(14, entity.getLatitude());
        stmt.bindDouble(15, entity.getLongitude());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(16, name);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(17, mobile);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Dispatch entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getWayBillNo());
 
        String wayBillTime = entity.getWayBillTime();
        if (wayBillTime != null) {
            stmt.bindString(2, wayBillTime);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(3, status);
        }
        stmt.bindString(4, entity.getCourierNO());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(5, address);
        }
 
        Boolean isSelected = entity.getIsSelected();
        if (isSelected != null) {
            stmt.bindLong(6, isSelected ? 1L: 0L);
        }
 
        Boolean isDeleted = entity.getIsDeleted();
        if (isDeleted != null) {
            stmt.bindLong(7, isDeleted ? 1L: 0L);
        }
 
        String notes = entity.getNotes();
        if (notes != null) {
            stmt.bindString(8, notes);
        }
 
        String noticeUpdateTime = entity.getNoticeUpdateTime();
        if (noticeUpdateTime != null) {
            stmt.bindString(9, noticeUpdateTime);
        }
 
        Integer isShow = entity.getIsShow();
        if (isShow != null) {
            stmt.bindLong(10, isShow);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(11, province);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(12, city);
        }
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(13, area);
        }
        stmt.bindDouble(14, entity.getLatitude());
        stmt.bindDouble(15, entity.getLongitude());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(16, name);
        }
 
        String mobile = entity.getMobile();
        if (mobile != null) {
            stmt.bindString(17, mobile);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    @Override
    public Dispatch readEntity(Cursor cursor, int offset) {
        Dispatch entity = new Dispatch( //
            cursor.getString(offset + 0), // wayBillNo
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // wayBillTime
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // status
            cursor.getString(offset + 3), // courierNO
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // address
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // isSelected
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // isDeleted
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // notes
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // noticeUpdateTime
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // isShow
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // province
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // city
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // area
            cursor.getDouble(offset + 13), // latitude
            cursor.getDouble(offset + 14), // longitude
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // name
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // mobile
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Dispatch entity, int offset) {
        entity.setWayBillNo(cursor.getString(offset + 0));
        entity.setWayBillTime(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStatus(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCourierNO(cursor.getString(offset + 3));
        entity.setAddress(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsSelected(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setIsDeleted(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setNotes(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setNoticeUpdateTime(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIsShow(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setProvince(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setCity(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setArea(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setLatitude(cursor.getDouble(offset + 13));
        entity.setLongitude(cursor.getDouble(offset + 14));
        entity.setName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setMobile(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    @Override
    protected final String updateKeyAfterInsert(Dispatch entity, long rowId) {
        return entity.getWayBillNo();
    }
    
    @Override
    public String getKey(Dispatch entity) {
        if(entity != null) {
            return entity.getWayBillNo();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Dispatch entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}