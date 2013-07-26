package com.barcodescanner.client.barcodescanner;

import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.JavaScriptObject;

public class BarcodescannerPhonegapImpl implements Barcodescanner{
    private boolean initialized;
    private JavaScriptObject bcs;
	@Override
	public void initialize() {
		 try {
             bcs = initializeNative();
             initialized = true;
     } catch (JavaScriptException e) {
             throw new IllegalStateException("could not initialize Childbrowser plugin: " + e.getMessage());
     }

		
	}

	private native JavaScriptObject initializeNative() /*-{
	 return $wnd.plugins.barcodeScanner;
	 }-*/;

	@Override
	public void scan(BarcodescannerCallback callback) {
		if (!initialized) {
		      throw new IllegalStateException("you have to initialize BarecodeScanner before using it");
		    }
		scan0(callback);
	}

	private native void scan0(BarcodescannerCallback callback) /*-{
			var successCallback = function(data) {
				callback.@com.mgwtphone.client.barcodescanner.BarcodescannerCallback::onSuccess(Lcom/mgwtphone/client/barcodescanner/BarcodeScannerData;)(data);
			//callback.@com.mgwtphone.client.barcodescanner.BarcodescannerCallback::onSuccess(Ljava/lang/String;)(data);
		};
		var errorCallback = function(message) {
			callback.@com.mgwtphone.client.barcodescanner.BarcodescannerCallback::onFailure(Ljava/lang/String;)(message);
		};
		
		$wnd.plugins.barcodeScanner.scan($entry(successCallback),
				$entry(errorCallback));
	}-*/;

}
