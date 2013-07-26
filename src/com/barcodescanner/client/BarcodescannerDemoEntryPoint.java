package com.barcodescanner.client;

import com.barcodescanner.client.barcodescanner.BarcodeScannerData;
import com.barcodescanner.client.barcodescanner.Barcodescanner;
import com.barcodescanner.client.barcodescanner.BarcodescannerCallback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.dialog.AlertDialog;
import com.googlecode.mgwt.ui.client.widget.Button;

/**
 */
public class BarcodescannerDemoEntryPoint implements EntryPoint {
	

	@Override
	public void onModuleLoad() {
		final PhoneGap phoneGap = GWT.create(PhoneGap.class);
		RootPanel.get().add(new Label("DEMO"));
		// set viewport and other settings for mobile
		MGWT.applySettings(MGWTSettings.getAppSetting());

		phoneGap.addHandler(new PhoneGapAvailableHandler() {

			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {

				// init BarcodeScanner
				final Barcodescanner bcs = GWT.create(Barcodescanner.class);
				bcs.initialize();
				phoneGap.loadPlugin("BarcodeScanner", bcs);

				// Button start scan
				final Button bScan = new Button("Scan");

				bScan.addTapHandler(new TapHandler() {

					@Override
					public void onTap(TapEvent event) {
						bcs.scan(new BarcodescannerCallback() {

							@Override
							public void onSuccess(BarcodeScannerData data) {
								new AlertDialog("Success", data.getText())
										.show();
							}

							@Override
							public void onFailure(String message) {
								new AlertDialog("Fail", message).show();
							}
						});

					}
				});

				// add Button ton rootPanel
				RootPanel.get().add(bScan);
			}

		});
		phoneGap.initializePhoneGap();
	}
}
