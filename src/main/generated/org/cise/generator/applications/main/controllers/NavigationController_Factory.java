package org.cise.generator.applications.main.controllers;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NavigationController_Factory implements Factory<NavigationController> {
  private final MembersInjector<NavigationController> navigationControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public NavigationController_Factory(
      MembersInjector<NavigationController> navigationControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert navigationControllerMembersInjector != null;
    this.navigationControllerMembersInjector = navigationControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public NavigationController get() {
    return MembersInjectors.injectMembers(
        navigationControllerMembersInjector,
        new NavigationController(mainControllerProvider.get()));
  }

  public static Factory<NavigationController> create(
      MembersInjector<NavigationController> navigationControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new NavigationController_Factory(
        navigationControllerMembersInjector, mainControllerProvider);
  }
}
