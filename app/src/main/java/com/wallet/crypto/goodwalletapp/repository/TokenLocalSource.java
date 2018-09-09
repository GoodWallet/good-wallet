package com.wallet.crypto.goodwalletapp.repository;

import com.wallet.crypto.goodwalletapp.entity.NetworkInfo;
import com.wallet.crypto.goodwalletapp.entity.TokenInfo;
import com.wallet.crypto.goodwalletapp.entity.Wallet;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface TokenLocalSource {
    Completable put(NetworkInfo networkInfo, Wallet wallet, TokenInfo tokenInfo);
    Single<TokenInfo[]> fetch(NetworkInfo networkInfo, Wallet wallet);
}
