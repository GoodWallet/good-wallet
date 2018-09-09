package com.wallet.crypto.goodwalletapp.di;

import com.wallet.crypto.goodwalletapp.interact.ImportWalletInteract;
import com.wallet.crypto.goodwalletapp.repository.PasswordStore;
import com.wallet.crypto.goodwalletapp.repository.WalletRepositoryType;
import com.wallet.crypto.goodwalletapp.viewmodel.ImportWalletViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class ImportModule {
    @Provides
    ImportWalletViewModelFactory provideImportWalletViewModelFactory(
            ImportWalletInteract importWalletInteract) {
        return new ImportWalletViewModelFactory(importWalletInteract);
    }

    @Provides
    ImportWalletInteract provideImportWalletInteract(
            WalletRepositoryType walletRepository, PasswordStore passwordStore) {
        return new ImportWalletInteract(walletRepository, passwordStore);
    }
}
