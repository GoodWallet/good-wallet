package com.wallet.crypto.goodwalletapp.di;


import com.wallet.crypto.goodwalletapp.interact.FindDefaultNetworkInteract;
import com.wallet.crypto.goodwalletapp.repository.EthereumNetworkRepositoryType;
import com.wallet.crypto.goodwalletapp.viewmodel.GasSettingsViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class GasSettingsModule {

    @Provides
    public GasSettingsViewModelFactory provideGasSettingsViewModelFactory(FindDefaultNetworkInteract findDefaultNetworkInteract) {
        return new GasSettingsViewModelFactory(findDefaultNetworkInteract);
    }

    @Provides
    FindDefaultNetworkInteract provideFindDefaultNetworkInteract(
            EthereumNetworkRepositoryType ethereumNetworkRepositoryType) {
        return new FindDefaultNetworkInteract(ethereumNetworkRepositoryType);
    }
}
