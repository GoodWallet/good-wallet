package com.wallet.crypto.goodwalletapp.di;

import com.wallet.crypto.goodwalletapp.interact.FindDefaultWalletInteract;
import com.wallet.crypto.goodwalletapp.repository.WalletRepositoryType;
import com.wallet.crypto.goodwalletapp.router.ManageWalletsRouter;

import dagger.Module;
import dagger.Provides;

@Module
class SettingsFragmentModule {
    @Provides
    FindDefaultWalletInteract provideFindDefaultWalletInteract(WalletRepositoryType walletRepository) {
        return new FindDefaultWalletInteract(walletRepository);
    }

    @Provides
    ManageWalletsRouter provideManageWalletsRouter() {
        return new ManageWalletsRouter();
    }
}
