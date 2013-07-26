package com.barcodescanner.client.barcodescanner;


public interface BarcodescannerCallback {
	public void onSuccess(BarcodeScannerData data);

	public void onFailure(String message);
}
