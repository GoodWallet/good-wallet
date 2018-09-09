package com.wallet.crypto.goodwalletapp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.wallet.crypto.goodwalletapp.interact.CreateWalletInteract;
import com.wallet.crypto.goodwalletapp.interact.DeleteWalletInteract;
import com.wallet.crypto.goodwalletapp.interact.ExportWalletInteract;
import com.wallet.crypto.goodwalletapp.interact.FetchWalletsInteract;
import com.wallet.crypto.goodwalletapp.interact.FindDefaultWalletInteract;
import com.wallet.crypto.goodwalletapp.interact.SetDefaultWalletInteract;
import com.wallet.crypto.goodwalletapp.router.ImportWalletRouter;
import com.wallet.crypto.goodwalletapp.router.TransactionsRouter;

import javax.inject.Inject;

public class WalletsViewModelFactory implements ViewModelProvider.Factory {

	private final CreateWalletInteract createWalletInteract;
	private final SetDefaultWalletInteract setDefaultWalletInteract;
	private final DeleteWalletInteract deleteWalletInteract;
	private final FetchWalletsInteract fetchWalletsInteract;
	private final FindDefaultWalletInteract findDefaultWalletInteract;
    private final ExportWalletInteract exportWalletInteract;

	private final ImportWalletRouter importWalletRouter;
    private final TransactionsRouter transactionsRouter;


    @Inject
	public WalletsViewModelFactory(
            CreateWalletInteract createWalletInteract,
            SetDefaultWalletInteract setDefaultWalletInteract,
            DeleteWalletInteract deleteWalletInteract,
            FetchWalletsInteract fetchWalletsInteract,
            FindDefaultWalletInteract findDefaultWalletInteract,
            ExportWalletInteract exportWalletInteract,
            ImportWalletRouter importWalletRouter,
            TransactionsRouter transactionsRouter) {
		this.createWalletInteract = createWalletInteract;
		this.setDefaultWalletInteract = setDefaultWalletInteract;
		this.deleteWalletInteract = deleteWalletInteract;
		this.fetchWalletsInteract = fetchWalletsInteract;
		this.findDefaultWalletInteract = findDefaultWalletInteract;
		this.exportWalletInteract = exportWalletInteract;
		this.importWalletRouter = importWalletRouter;
		this.transactionsRouter = transactionsRouter;
	}

	@NonNull
	@Override
	public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
		return (T) new WalletsViewModel(
                createWalletInteract,
                setDefaultWalletInteract,
                deleteWalletInteract,
                fetchWalletsInteract,
                findDefaultWalletInteract,
                exportWalletInteract,
                importWalletRouter,
                transactionsRouter);
	}
}
