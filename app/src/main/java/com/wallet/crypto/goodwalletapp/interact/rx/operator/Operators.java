package com.wallet.crypto.goodwalletapp.interact.rx.operator;

import com.wallet.crypto.goodwalletapp.entity.Wallet;
import com.wallet.crypto.goodwalletapp.repository.PasswordStore;
import com.wallet.crypto.goodwalletapp.repository.WalletRepositoryType;

import io.reactivex.CompletableOperator;
import io.reactivex.SingleTransformer;

public class Operators {

    public static SingleTransformer<Wallet, Wallet> savePassword(
            PasswordStore passwordStore, WalletRepositoryType walletRepository, String password) {
        return new SavePasswordOperator(passwordStore, walletRepository, password);
    }

    public static CompletableOperator completableErrorProxy(Throwable throwable) {
        return new CompletableErrorProxyOperator(throwable);
    }
}
