package cdictv.tiyitao.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import cdictv.tiyitao.bean.WodeyijanBean;


public class DataBaseHelp extends OrmLiteSqliteOpenHelper {

    public  static  DataBaseHelp dataBaseHelp;

    private DataBaseHelp(Context context) {
        super(context, "dititain.db", null, 1);
    }

    public static DataBaseHelp getDataBase(Context context ){
        synchronized (DataBaseHelp.class){
           if(dataBaseHelp == null){
               dataBaseHelp = new DataBaseHelp(context);
           }
       }
       return dataBaseHelp;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        //创建数据库
        try {
            TableUtils.createTable(connectionSource, WodeyijanBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
