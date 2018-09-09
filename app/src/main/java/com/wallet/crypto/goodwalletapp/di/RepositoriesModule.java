package com.wallet.crypto.goodwalletapp.di;

import android.content.Context;

import com.google.gson.Gson;
import com.wallet.crypto.goodwalletapp.repository.EthereumNetworkRepository;
import com.wallet.crypto.goodwalletapp.repository.EthereumNetworkRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.PreferenceRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.RealmTokenSource;
import com.wallet.crypto.goodwalletapp.repository.SharedPreferenceRepository;
import com.wallet.crypto.goodwalletapp.repository.TokenLocalSource;
import com.wallet.crypto.goodwalletapp.repository.TokenRepository;
import com.wallet.crypto.goodwalletapp.repository.TokenRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.TransactionInMemorySource;
import com.wallet.crypto.goodwalletapp.repository.TransactionLocalSource;
import com.wallet.crypto.goodwalletapp.repository.TransactionRepository;
import com.wallet.crypto.goodwalletapp.repository.TransactionRepositoryType;
import com.wallet.crypto.goodwalletapp.repository.WalletRepository;
import com.wallet.crypto.goodwalletapp.repository.WalletRepositoryType;
import com.wallet.crypto.goodwalletapp.service.AccountKeystoreService;
import com.wallet.crypto.goodwalletapp.service.BlockExplorerClient;
import com.wallet.crypto.goodwalletapp.service.BlockExplorerClientType;
import com.wallet.crypto.goodwalletapp.service.EthplorerTokenService;
import com.wallet.crypto.goodwalletapp.service.GethKeystoreAccountService;
import com.wallet.crypto.goodwalletapp.service.TickerService;
import com.wallet.crypto.goodwalletapp.service.TokenExplorerClientType;
import com.wallet.crypto.goodwalletapp.service.GoodWalletTickerService;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class RepositoriesModule {
	@Singleton
	@Provides
	PreferenceRepositoryType providePreferenceRepository(Context context) {
		return new SharedPreferenceRepository(context);
	}

	@Singleton
	@Provides
	AccountKeystoreService provideAccountKeyStoreService(Context context) {
        File file = new File(context.getFilesDir(), "keystore/keystore");
		return new GethKeystoreAccountService(file);
	}

	@Singleton
    @Provides
    TickerService provideTickerService(OkHttpClient httpClient, Gson gson) {
	    return new GoodWalletTickerService(httpClient, gson);
    }

	@Singleton
	@Provides
	EthereumNetworkRepositoryType provideEthereumNetworkRepository(
            PreferenceRepositoryType preferenceRepository,
            TickerService tickerService) {
		return new EthereumNetworkRepository(preferenceRepository, tickerService);
	}

	@Singleton
	@Provides
    WalletRepositoryType provideWalletRepository(
            OkHttpClient okHttpClient,
			PreferenceRepositoryType preferenceRepositoryType,
			AccountKeystoreService accountKeystoreService,
			EthereumNetworkRepositoryType networkRepository) {
		return new WalletRepository(
		        okHttpClient, preferenceRepositoryType, accountKeystoreService, networkRepository);
	}

	@Singleton
	@Provides
	TransactionRepositoryType provideTransactionRepository(
			EthereumNetworkRepositoryType networkRepository,
			AccountKeystoreService accountKeystoreService,
			BlockExplorerClientType blockExplorerClient) {
		TransactionLocalSource inMemoryCache = new TransactionInMemorySource();
		TransactionLocalSource inDiskCache = null;
		return new TransactionRepository(
				networkRepository,
				accountKeystoreService,
				inMemoryCache,
				inDiskCache,
				blockExplorerClient);
	}

	@Singleton
	@Provides
	BlockExplorerClientType provideBlockExplorerClient(
			OkHttpClient httpClient,
			Gson gson,
			EthereumNetworkRepositoryType ethereumNetworkRepository) {
		return new BlockExplorerClient(httpClient, gson, ethereumNetworkRepository);
	}

	@Singleton
    @Provides
    TokenRepositoryType provideTokenRepository(
            OkHttpClient okHttpClient,
            EthereumNetworkRepositoryType ethereumNetworkRepository,
            TokenExplorerClientType tokenExplorerClientType,
            TokenLocalSource tokenLocalSource) {
	    return new TokenRepository(
	            okHttpClient,
	            ethereumNetworkRepository,
	            tokenExplorerClientType,
                tokenLocalSource);
    }

	@Singleton
    @Provides
    TokenExplorerClientType provideTokenService(OkHttpClient okHttpClient, Gson gson) {
	    return new EthplorerTokenService(okHttpClient, gson);
    }

    @Singleton
    @Provides
    TokenLocalSource provideRealmTokenSource() {
	    return new RealmTokenSource();
    }
}
