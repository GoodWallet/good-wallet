package com.wallet.crypto.goodwalletapp.ui.widget;

import android.view.View;

import com.wallet.crypto.goodwalletapp.entity.Transaction;

public interface OnTransactionClickListener {
    void onTransactionClick(View view, Transaction transaction);
}
