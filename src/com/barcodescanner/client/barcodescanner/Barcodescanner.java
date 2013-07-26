package com.barcodescanner.client.barcodescanner;

import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;

public interface Barcodescanner extends PhoneGapPlugin {
	void scan (BarcodescannerCallback successCallback);
}
