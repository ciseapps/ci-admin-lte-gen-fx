package org.cise.generator.modules.green;

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
public final class GreenController_Factory implements Factory<GreenController> {
  private final MembersInjector<GreenController> greenControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public GreenController_Factory(
      MembersInjector<GreenController> greenControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert greenControllerMembersInjector != null;
    this.greenControllerMembersInjector = greenControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public GreenController get() {
    return MembersInjectors.injectMembers(
        greenControllerMembersInjector, new GreenController(mainControllerProvider.get()));
  }

  public static Factory<GreenController> create(
      MembersInjector<GreenController> greenControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new GreenController_Factory(greenControllerMembersInjector, mainControllerProvider);
  }
}
