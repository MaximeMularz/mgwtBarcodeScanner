package com.barcodescanner.client.barcodescanner;

import com.google.gwt.core.client.JavaScriptObject;


public class BarcodeScannerDataImpl extends JavaScriptObject implements BarcodeScannerData{

	protected BarcodeScannerDataImpl() {
	}
	
	@Override
	public final native String getText() /*-{
		return this.text;
	}-*/;

	@Override
	public final native String getFormat() /*-{
		return this.format;
	}-*/;

	@Override
	public final native boolean cancelled() /*-{
		return this.cancelled;
	}-*/;

}
