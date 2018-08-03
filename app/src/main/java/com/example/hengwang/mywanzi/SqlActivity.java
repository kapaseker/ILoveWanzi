package com.example.hengwang.mywanzi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SqlActivity extends AssignmentActivity {

    private myDataBaseHelper dbHelper;
    TextView mTextView;
    Button mBtninsert;
    Button mBtnOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        mTextView = findViewById(R.id.txt_info);
        mBtninsert = findViewById(R.id.btn_inseter);
        mBtnOutput = findViewById(R.id.btn_output);

        dbHelper = new myDataBaseHelper(this, "test.db", null, 1);
        dbHelper.getWritableDatabase();

        mBtninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str=dbHelper.insert("xiaoming",(float) 1.75,"gaofushuai");
                Toast.makeText(SqlActivity.this, "Insert succeeded", Toast.LENGTH_SHORT).show();

                mTextView.setText(str);

            }
        });
        mBtnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor=dbHelper.query("all");
                cursor.moveToLast();
                String name = cursor.getString(cursor.getColumnIndex("name"));
                float nheight;
               String height =  cursor.getString(cursor.getColumnIndex("height"));
               nheight =Float.parseFloat(height);
                String introduce = cursor.getString(cursor.getColumnIndex("introduce"));
                String str="name:"+name+"; height:"+nheight+"; introduce:"+introduce;
                 mTextView.setText(str);


            }
        });


    }


    public class myDataBaseHelper extends SQLiteOpenHelper {
        private static final String TABLE_NAME = "info";
        public static final String CREATE_DATA = "create table " + TABLE_NAME +

                "(id integer primary key autoincrement, "

                + "name text, "

                + "height real, "

                + "introduce text)";

        private Context mContext;


        public myDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_DATA);
            Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        public String getTime() {

            long time;//获取系统时间的10位的时间戳
            time = System.currentTimeMillis() / 1000;

            String str = String.valueOf(time);

            return str;

        }

        //插入一条记录
        public String insert(String Name, float height, String introduce) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            String str=null;

            Name = Name + getTime();
            introduce=introduce+getTime();
            cv.put("name", Name);
            cv.put("height", height);
            cv.put("introduce", introduce);
            str="name:"+Name+"; height:"+height+"; introduce:"+introduce;
            long row = db.insert(TABLE_NAME, null, cv);
            return str;
        }

        //根据条件查询
        public Cursor query(String args) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
            return cursor;
        }


    }

}
