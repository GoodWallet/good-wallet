package com.wallet.crypto.goodwalletapp.interact;


import com.wallet.crypto.goodwalletapp.entity.GasSettings;
import com.wallet.crypto.goodwalletapp.repository.PreferenceRepositoryType;

public class FetchGasSettingsInteract {
    private final PreferenceRepositoryType repository;

    public FetchGasSettingsInteract(PreferenceRepositoryType repository) {
        this.repository = repository;
    }

    public GasSettings fetch(boolean forTokenTransfer) {
        return repository.getGasSettings(forTokenTransfer);
    }

}
