package com.example.mejia.fragment;import com.example.meijia.R;import android.app.AlertDialog;import android.os.Bundle;import android.support.annotation.Nullable;import android.support.v4.app.Fragment;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;public class OdFragment extends Fragment{	@Override	public void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);					}	@Override	public View onCreateView(final LayoutInflater inflater, ViewGroup container,			Bundle savedInstanceState) {		View view			=  inflater.inflate(R.layout.fmore, container, false);						return view;	}	}