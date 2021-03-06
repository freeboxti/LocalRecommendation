package fi.uni.aalto.controllers;


import java.util.ArrayList;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;


public class MyOverlays extends ItemizedOverlay<OverlayItem>
{
	
	private static int maxNum = 100;
	
	private ArrayList<OverlayItem> overlays = new ArrayList<OverlayItem>();
	private ArrayList<String> infos = new ArrayList<String>();
	private int index = 0;

	private Context context;
	

	public MyOverlays(Context context, Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		this.context = context;
	}

	@Override
	protected OverlayItem createItem(int i) {
		return overlays.get(i);
	}


	public void addOverlay(OverlayItem newOverlay,String info) 
	{
		if(index == maxNum)
		{
			index = 0;
		}
		else
		{
			overlays.add(index, newOverlay);
			infos.add(info);
			index++;
			populate();
		}
	}


	@Override
	public int size() {
		return overlays.size();
	};
	
	protected boolean onTap(int index) {
		
		Builder builder = new AlertDialog.Builder(context);
		String info = infos.get(index);
		
		builder.setMessage(info);
		builder.setCancelable(true);
		AlertDialog dialog = builder.create();
		dialog.setButton("ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});
		
		dialog.show();
		return true;
	};
	
	


}
