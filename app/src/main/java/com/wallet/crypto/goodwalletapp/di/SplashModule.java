package com.wallet.crypto.goodwalletapp.di;

import com.wallet.crypto.goodwalletapp.interact.FetchWalletsInteract;
import com.wallet.crypto.goodwalletapp.repository.WalletRepositoryType;
import com.wallet.crypto.goodwalletapp.viewmodel.SplashViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashModule {

    @Provides
    SplashViewModelFactory provideSplashViewModelFactory(FetchWalletsInteract fetchWalletsInteract) {
        return new SplashViewModelFactory(fetchWalletsInteract);
    }

    @Provides
    FetchWalletsInteract provideFetchWalletInteract(WalletRepositoryType walletRepository) {
        return new FetchWalletsInteract(walletRepository);
    }
}
