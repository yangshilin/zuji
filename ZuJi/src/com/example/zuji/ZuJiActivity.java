package com.example.zuji;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zuji.adapter.ZuJiAdapter;
import com.example.zuji.javaclass.ZuJi;

public class ZuJiActivity extends Activity {
	ListView zujiListView;
	ZuJiAdapter zujiAdapter;
	List<ZuJi> zujiList;
	
	
	ImageButton zujiReturn;
	EditText zujieEditText;
	TextView fasongText;
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.zuji); 
        
        zujiList =new ArrayList<ZuJi>();
        ZuJi zuji=null;
        for(int i=0;i<2;i++){
        	zuji=new ZuJi();
        	if(i % 2==0){
        		zuji.setComeMsg(false);
        		zuji.setContent("hollo");
        		zuji.setZujiTime("2016-08-22 15:12:32");
        	}
        	zujiList.add(zuji);
        }
        
        
        
        zujiAdapter = new ZuJiAdapter(ZuJiActivity.this,zujiList);
        zujiListView.setAdapter(zujiAdapter);
        
        zujiReturn=(ImageButton)findViewById(R.id.zuji_return);
        zujieEditText=(EditText)findViewById(R.id.zuji_edittext);
        fasongText=(TextView)findViewById(R.id.zuji_fasong);
        
        zujiReturn.setOnClickListener(onClickListener);
        zujieEditText.setOnClickListener(onClickListener);
        fasongText.setOnClickListener(onClickListener);
        
    }
    OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.zuji_return:
				break;
			case R.id.zuji_edittext:
				break;
			case R.id.zuji_fasong:
				if (!zujieEditText.getText().toString().equals("")) {  
                    //发送消息  
                    send();  
                }else {  
                    Toast.makeText(ZuJiActivity.this, "发送消息不能为空", Toast.LENGTH_SHORT).show();  
                }  
				break;
			default:
				break;
			}
		}
    };
    private void send(){
    	ZuJi zuji=new ZuJi();
    	zuji.setZujiTime("2016-08-22 15:16:34");
    	zuji.setContent(zujieEditText.getText().toString());
    	zuji.setComeMsg(false);
    	zujiList.add(zuji);
    	zujiAdapter.notifyDataSetChanged();
    	zujiListView.setSelection(zujiList.size()-1);
    	zujieEditText.setText("");
    }

    

}