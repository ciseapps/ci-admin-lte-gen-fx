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
public final class HeaderController_Factory implements Factory<HeaderController> {
  private final MembersInjector<HeaderController> headerControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public HeaderController_Factory(
      MembersInjector<HeaderController> headerControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert headerControllerMembersInjector != null;
    this.headerControllerMembersInjector = headerControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public HeaderController get() {
    return MembersInjectors.injectMembers(
        headerControllerMembersInjector, new HeaderController(mainControllerProvider.get()));
  }

  public static Factory<HeaderController> create(
      MembersInjector<HeaderController> headerControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new HeaderController_Factory(headerControllerMembersInjector, mainControllerProvider);
  }
}
