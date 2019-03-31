package org.cise.generator.applications.main.controllers;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainControllerImpl_MembersInjector
    implements MembersInjector<MainControllerImpl> {
  private final Provider<HeaderController> headerControllerProvider;

  private final Provider<NavigationController> navigationControllerProvider;

  public MainControllerImpl_MembersInjector(
      Provider<HeaderController> headerControllerProvider,
      Provider<NavigationController> navigationControllerProvider) {
    assert headerControllerProvider != null;
    this.headerControllerProvider = headerControllerProvider;
    assert navigationControllerProvider != null;
    this.navigationControllerProvider = navigationControllerProvider;
  }

  public static MembersInjector<MainControllerImpl> create(
      Provider<HeaderController> headerControllerProvider,
      Provider<NavigationController> navigationControllerProvider) {
    return new MainControllerImpl_MembersInjector(
        headerControllerProvider, navigationControllerProvider);
  }

  @Override
  public void injectMembers(MainControllerImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.headerController = headerControllerProvider.get();
    instance.navigationController = navigationControllerProvider.get();
  }

  public static void injectHeaderController(
      MainControllerImpl instance, Provider<HeaderController> headerControllerProvider) {
    instance.headerController = headerControllerProvider.get();
  }

  public static void injectNavigationController(
      MainControllerImpl instance, Provider<NavigationController> navigationControllerProvider) {
    instance.navigationController = navigationControllerProvider.get();
  }
}
