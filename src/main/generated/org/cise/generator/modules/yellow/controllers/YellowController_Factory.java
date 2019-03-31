package org.cise.generator.modules.yellow.controllers;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class YellowController_Factory implements Factory<YellowController> {
  private final MembersInjector<YellowController> yellowControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public YellowController_Factory(
      MembersInjector<YellowController> yellowControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert yellowControllerMembersInjector != null;
    this.yellowControllerMembersInjector = yellowControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public YellowController get() {
    return MembersInjectors.injectMembers(
        yellowControllerMembersInjector, new YellowController(mainControllerProvider.get()));
  }

  public static Factory<YellowController> create(
      MembersInjector<YellowController> yellowControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new YellowController_Factory(yellowControllerMembersInjector, mainControllerProvider);
  }
}
