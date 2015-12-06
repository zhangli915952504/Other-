package com.example.other;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	public void click(View view){
		//得到中间人
		ContentResolver resolver=getContentResolver();
		Uri uri=Uri.parse("content://com.zhangli.db.personprovider/query/10");
		Cursor cursor=resolver.query(uri, null, null, null, null);
		while(cursor.moveToNext()){
			String name =cursor.getString(cursor.getColumnIndex("name"));
			String number=cursor.getString(cursor.getColumnIndex("number"));
			System.out.print("name:"+name+",number:"+number);
		}
		cursor.close();
		
	}
	
	public void delete(View view){
		ContentResolver resolver=getContentResolver();
		Uri uri=Uri.parse("content://com.zhangli.db.personprovider/delete");
		resolver.delete(uri,"name=?",new String[]{"狂奔的第0奶牛"} );
	}
	
	public void update(View view){
		ContentResolver resolver=getContentResolver();
		Uri uri=Uri.parse("content://com.zhangli.db.personprovider/update");
		ContentValues values=new ContentValues();
		values.put("number","110");
		resolver.update(uri, values, "name=?", new String[]{"狂奔的第1奶牛"});
	}
	
	public void insert(View view){
		ContentResolver resolver=getContentResolver();
		Uri uri=Uri.parse("content://com.zhangli.db.personprovider/insert");
		ContentValues values=new ContentValues();
		values.put("number","99999");
		values.put("name", "骑着野猪的奶牛");
		resolver.insert(uri, values);
	}
	
}
