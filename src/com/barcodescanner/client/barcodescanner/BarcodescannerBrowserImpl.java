package com.barcodescanner.client.barcodescanner;

public class BarcodescannerBrowserImpl implements Barcodescanner{
	
	private class DataMock implements BarcodeScannerData {

		@Override
		public String getText() {
			return "BarCodeScanner";
		}

		@Override
		public String getFormat() {
			return "QRCode";
		}

		@Override
		public boolean cancelled() {
			return false;
		}
		
	}
	
	private boolean initialized;

	@Override
	public void initialize() {
		initialized = true;
	}

	@Override
	public void scan(BarcodescannerCallback callback) {
		if(!initialized) return;
		BarcodeScannerData data = new DataMock();
		callback.onSuccess(data);
	}

}
