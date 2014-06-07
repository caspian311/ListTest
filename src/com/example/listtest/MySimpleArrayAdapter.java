package com.example.listtest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final ArrayList<String> values;

	public MySimpleArrayAdapter(Context context, ArrayList<String> values) {
		super(context, R.layout.rowlayout, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

		textView.setText(values.get(position));
		imageView.setImageResource(getImageResource(values.get(position)));

		return rowView;
	}

	public int getImageResource(String s) {
		if (s.startsWith("iPhone")) {
			return R.drawable.foo;
		} else {
			return android.R.drawable.button_onoff_indicator_on;
		}
	}
}
