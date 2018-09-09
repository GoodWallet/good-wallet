package com.wallet.crypto.goodwalletapp.service;

import com.wallet.crypto.goodwalletapp.entity.TokenInfo;

import io.reactivex.Observable;

public interface TokenExplorerClientType {
    Observable<TokenInfo[]> fetch(String walletAddress);
}