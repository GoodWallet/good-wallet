package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.NetworkInfo;

public interface OnNetworkChangeListener {
	void onNetworkChanged(NetworkInfo networkInfo);
}
