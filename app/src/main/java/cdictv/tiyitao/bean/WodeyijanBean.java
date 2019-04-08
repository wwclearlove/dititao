package cdictv.tiyitao.bean;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "WodeyijanBean")
public class WodeyijanBean implements Serializable{

    @DatabaseField(columnName = "biaoti")
    public String biaoti;
    @DatabaseField(columnName = "tijiaoshijian")
    public String tijiaoshijian;
    @DatabaseField(columnName = "huifushijina")
    public String huifushijina;
    @DatabaseField(columnName = "wodeyijian")
    public String wodeyijian;
    @DatabaseField(columnName = "shouji")
    public String shouji;

    public WodeyijanBean() { }
}
