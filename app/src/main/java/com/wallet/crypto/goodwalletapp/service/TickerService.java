package com.wallet.crypto.goodwalletapp.service;

import com.wallet.crypto.goodwalletapp.entity.Ticker;

import io.reactivex.Observable;

public interface TickerService {

    Observable<Ticker> fetchTickerPrice(String ticker);
}
