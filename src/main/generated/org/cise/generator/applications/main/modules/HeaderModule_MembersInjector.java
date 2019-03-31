package org.cise.generator.applications.main.modules;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.controllers.MainController;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HeaderModule_MembersInjector implements MembersInjector<HeaderModule> {
  private final Provider<MainController> mainControllerProvider;

  public HeaderModule_MembersInjector(Provider<MainController> mainControllerProvider) {
    assert mainControllerProvider != null;
    this.mainControllerProvider = mainControllerProvider;
  }

  public static MembersInjector<HeaderModule> create(
      Provider<MainController> mainControllerProvider) {
    return new HeaderModule_MembersInjector(mainControllerProvider);
  }

  @Override
  public void injectMembers(HeaderModule instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.provideHeaderController(mainControllerProvider.get());
  }
}
