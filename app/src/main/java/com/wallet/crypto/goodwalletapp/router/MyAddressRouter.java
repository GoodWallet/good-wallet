package com.wallet.crypto.goodwalletapp.router;

import android.content.Context;
import android.content.Intent;

import com.wallet.crypto.goodwalletapp.entity.Wallet;
import com.wallet.crypto.goodwalletapp.ui.MyAddressActivity;

import static com.wallet.crypto.goodwalletapp.C.Key.WALLET;

public class MyAddressRouter {

    public void open(Context context, Wallet wallet) {
        Intent intent = new Intent(context, MyAddressActivity.class);
        intent.putExtra(WALLET, wallet);
        context.startActivity(intent);
    }
}
