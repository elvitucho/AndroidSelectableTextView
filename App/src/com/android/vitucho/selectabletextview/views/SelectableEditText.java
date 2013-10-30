package com.android.vitucho.selectabletextview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android.vitucho.selectabletextview.R;

public class SelectableEditText extends EditText {

	public SelectableEditText(Context context) {
		super(context);
		init();
	}

	public SelectableEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public SelectableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init() {
		this.setTextIsSelectable(true);
		this.setCustomSelectionActionModeCallback(new Callback() {
			
			@Override
			public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
				return true;
			}
			
			@Override
			public void onDestroyActionMode(ActionMode mode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onCreateActionMode(ActionMode mode, Menu menu) {
				// Inflate a menu resource providing context menu items
				MenuInflater inflater = mode.getMenuInflater();
				// Assumes that you have "contexual.xml" menu resources
				inflater.inflate(R.menu.contextual, menu);
				return true;
			}
			
			@Override
			public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
				Toast.makeText(SelectableEditText.this.getContext(), item.getTitle()+" selected", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
	}
}
