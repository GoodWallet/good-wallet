package com.wallet.crypto.goodwalletapp.di;

import com.wallet.crypto.goodwalletapp.router.ConfirmationRouter;
import com.wallet.crypto.goodwalletapp.viewmodel.SendViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
class SendModule {
    @Provides
    SendViewModelFactory provideSendViewModelFactory(ConfirmationRouter confirmationRouter) {
        return new SendViewModelFactory(confirmationRouter);
    }

    @Provides
    ConfirmationRouter provideConfirmationRouter() {
        return new ConfirmationRouter();
    }
}
