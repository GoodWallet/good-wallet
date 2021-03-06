package com.wallet.crypto.goodwalletapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.wallet.crypto.goodwalletapp.repository.EthereumNetworkRepository;
import com.wallet.crypto.goodwalletapp.repository.EthereumNetworkRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.PreferenceRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.SharedPreferenceRepository;

import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EthereumNetworkRepositoryTest {

	private EthereumNetworkRepositoryType networkRepository;

	@Before
	public void setUp() {
		Context context = InstrumentationRegistry.getTargetContext();
		PreferenceRepositoryType preferenceRepositoryType = new SharedPreferenceRepository(context);
		networkRepository = new EthereumNetworkRepository(preferenceRepositoryType);
	}

}
