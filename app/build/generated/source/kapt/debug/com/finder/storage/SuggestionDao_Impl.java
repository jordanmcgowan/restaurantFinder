package com.finder.storage;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.finder.Suggestion;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class SuggestionDao_Impl implements SuggestionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Suggestion> __insertionAdapterOfSuggestion;

  private final EntityDeletionOrUpdateAdapter<Suggestion> __updateAdapterOfSuggestion;

  public SuggestionDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSuggestion = new EntityInsertionAdapter<Suggestion>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `suggestions` (`placeId`,`name`,`imageReference`,`address`,`rating`,`ratingCount`,`priceLevel`,`lat`,`lng`,`isFavorite`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Suggestion value) {
        if (value.getPlaceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlaceId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getImageReference() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageReference());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getRating() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getRating());
        }
        if (value.getRatingCount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getRatingCount());
        }
        if (value.getPriceLevel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getPriceLevel());
        }
        if (value.getLat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLat());
        }
        if (value.getLng() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getLng());
        }
        final int _tmp;
        _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(10, _tmp);
      }
    };
    this.__updateAdapterOfSuggestion = new EntityDeletionOrUpdateAdapter<Suggestion>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `suggestions` SET `placeId` = ?,`name` = ?,`imageReference` = ?,`address` = ?,`rating` = ?,`ratingCount` = ?,`priceLevel` = ?,`lat` = ?,`lng` = ?,`isFavorite` = ? WHERE `placeId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Suggestion value) {
        if (value.getPlaceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPlaceId());
        }
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getImageReference() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageReference());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        if (value.getRating() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getRating());
        }
        if (value.getRatingCount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getRatingCount());
        }
        if (value.getPriceLevel() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getPriceLevel());
        }
        if (value.getLat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLat());
        }
        if (value.getLng() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getLng());
        }
        final int _tmp;
        _tmp = value.isFavorite() ? 1 : 0;
        stmt.bindLong(10, _tmp);
        if (value.getPlaceId() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPlaceId());
        }
      }
    };
  }

  @Override
  public Object insertSuggestion(final Suggestion suggestion,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSuggestion.insert(suggestion);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateSuggestion(final Suggestion suggestion,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfSuggestion.handle(suggestion);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Suggestion>> getCachedSuggestions() {
    final String _sql = "SELECT * FROM suggestions";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"suggestions"}, false, new Callable<List<Suggestion>>() {
      @Override
      public List<Suggestion> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlaceId = CursorUtil.getColumnIndexOrThrow(_cursor, "placeId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageReference = CursorUtil.getColumnIndexOrThrow(_cursor, "imageReference");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRatingCount = CursorUtil.getColumnIndexOrThrow(_cursor, "ratingCount");
          final int _cursorIndexOfPriceLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "priceLevel");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final List<Suggestion> _result = new ArrayList<Suggestion>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Suggestion _item;
            final String _tmpPlaceId;
            if (_cursor.isNull(_cursorIndexOfPlaceId)) {
              _tmpPlaceId = null;
            } else {
              _tmpPlaceId = _cursor.getString(_cursorIndexOfPlaceId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpImageReference;
            if (_cursor.isNull(_cursorIndexOfImageReference)) {
              _tmpImageReference = null;
            } else {
              _tmpImageReference = _cursor.getString(_cursorIndexOfImageReference);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final Float _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            }
            final Integer _tmpRatingCount;
            if (_cursor.isNull(_cursorIndexOfRatingCount)) {
              _tmpRatingCount = null;
            } else {
              _tmpRatingCount = _cursor.getInt(_cursorIndexOfRatingCount);
            }
            final Integer _tmpPriceLevel;
            if (_cursor.isNull(_cursorIndexOfPriceLevel)) {
              _tmpPriceLevel = null;
            } else {
              _tmpPriceLevel = _cursor.getInt(_cursorIndexOfPriceLevel);
            }
            final Float _tmpLat;
            if (_cursor.isNull(_cursorIndexOfLat)) {
              _tmpLat = null;
            } else {
              _tmpLat = _cursor.getFloat(_cursorIndexOfLat);
            }
            final Float _tmpLng;
            if (_cursor.isNull(_cursorIndexOfLng)) {
              _tmpLng = null;
            } else {
              _tmpLng = _cursor.getFloat(_cursorIndexOfLng);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            _item = new Suggestion(_tmpPlaceId,_tmpName,_tmpImageReference,_tmpAddress,_tmpRating,_tmpRatingCount,_tmpPriceLevel,_tmpLat,_tmpLng,_tmpIsFavorite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Suggestion> getSuggestionFromPlaceId(final String placeId) {
    final String _sql = "SELECT * FROM suggestions WHERE placeId IS ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (placeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, placeId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"suggestions"}, false, new Callable<Suggestion>() {
      @Override
      public Suggestion call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlaceId = CursorUtil.getColumnIndexOrThrow(_cursor, "placeId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfImageReference = CursorUtil.getColumnIndexOrThrow(_cursor, "imageReference");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfRatingCount = CursorUtil.getColumnIndexOrThrow(_cursor, "ratingCount");
          final int _cursorIndexOfPriceLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "priceLevel");
          final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
          final int _cursorIndexOfLng = CursorUtil.getColumnIndexOrThrow(_cursor, "lng");
          final int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
          final Suggestion _result;
          if(_cursor.moveToFirst()) {
            final String _tmpPlaceId;
            if (_cursor.isNull(_cursorIndexOfPlaceId)) {
              _tmpPlaceId = null;
            } else {
              _tmpPlaceId = _cursor.getString(_cursorIndexOfPlaceId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpImageReference;
            if (_cursor.isNull(_cursorIndexOfImageReference)) {
              _tmpImageReference = null;
            } else {
              _tmpImageReference = _cursor.getString(_cursorIndexOfImageReference);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final Float _tmpRating;
            if (_cursor.isNull(_cursorIndexOfRating)) {
              _tmpRating = null;
            } else {
              _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            }
            final Integer _tmpRatingCount;
            if (_cursor.isNull(_cursorIndexOfRatingCount)) {
              _tmpRatingCount = null;
            } else {
              _tmpRatingCount = _cursor.getInt(_cursorIndexOfRatingCount);
            }
            final Integer _tmpPriceLevel;
            if (_cursor.isNull(_cursorIndexOfPriceLevel)) {
              _tmpPriceLevel = null;
            } else {
              _tmpPriceLevel = _cursor.getInt(_cursorIndexOfPriceLevel);
            }
            final Float _tmpLat;
            if (_cursor.isNull(_cursorIndexOfLat)) {
              _tmpLat = null;
            } else {
              _tmpLat = _cursor.getFloat(_cursorIndexOfLat);
            }
            final Float _tmpLng;
            if (_cursor.isNull(_cursorIndexOfLng)) {
              _tmpLng = null;
            } else {
              _tmpLng = _cursor.getFloat(_cursorIndexOfLng);
            }
            final boolean _tmpIsFavorite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
            _tmpIsFavorite = _tmp != 0;
            _result = new Suggestion(_tmpPlaceId,_tmpName,_tmpImageReference,_tmpAddress,_tmpRating,_tmpRatingCount,_tmpPriceLevel,_tmpLat,_tmpLng,_tmpIsFavorite);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
