package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.GasSettings;

public interface PreferenceRepositoryType {
	String getCurrentWalletAddress();
	void setCurrentWalletAddress(String address);

	String getDefaultNetwork();
	void setDefaultNetwork(String netName);

	GasSettings getGasSettings(boolean forTokenTransfer);
	void setGasSettings(GasSettings gasPrice);

}
