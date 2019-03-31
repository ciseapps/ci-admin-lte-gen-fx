package org.cise.generator.modules.red;

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
public final class RedController_Factory implements Factory<RedController> {
  private final MembersInjector<RedController> redControllerMembersInjector;

  private final Provider<MainController> mainControllerProvider;

  public RedController_Factory(
      MembersInjector<RedController> redControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    assert redControllerMembersInjector != null;
    this.redControllerMembersInjector = redControllerMembersInjector;
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  @Override
  public RedController get() {
    return MembersInjectors.injectMembers(
        redControllerMembersInjector, new RedController(mainControllerProvider.get()));
  }

  public static Factory<RedController> create(
      MembersInjector<RedController> redControllerMembersInjector,
      Provider<MainController> mainControllerProvider) {
    return new RedController_Factory(redControllerMembersInjector, mainControllerProvider);
  }
}
