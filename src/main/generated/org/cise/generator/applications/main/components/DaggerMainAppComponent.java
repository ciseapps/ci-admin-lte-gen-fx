package org.cise.generator.applications.main.components;

import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

import org.cise.generator.applications.main.modules.MainControllerModule;
import org.cise.generator.modules.green.GreenController_Factory;
import org.cise.generator.modules.red.RedController_Factory;
import org.cise.generator.applications.main.controllers.HeaderController;
import org.cise.generator.applications.main.controllers.HeaderController_Factory;
import org.cise.generator.applications.main.controllers.MainController;
import org.cise.generator.applications.main.controllers.MainControllerImpl;
import org.cise.generator.applications.main.controllers.MainControllerImpl_MembersInjector;
import org.cise.generator.applications.main.controllers.NavigationController;
import org.cise.generator.applications.main.controllers.NavigationController_Factory;
import org.cise.generator.applications.main.controllers.NavigationController_MembersInjector;
import org.cise.generator.applications.main.modules.MainControllerModule_ProvideMainControllerFactory;
import org.cise.generator.modules.green.GreenController;
import org.cise.generator.modules.red.RedController;
import org.cise.generator.modules.yellow.controllers.YellowController;
import org.cise.generator.modules.yellow.controllers.YellowController_Factory;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerMainAppComponent implements MainAppComponent {
  private Provider<MainController> provideMainControllerProvider;

  private Provider<HeaderController> headerControllerProvider;

  private Provider<YellowController> yellowControllerProvider;

  private Provider<RedController> redControllerProvider;

  private Provider<GreenController> greenControllerProvider;

  private MembersInjector<NavigationController> navigationControllerMembersInjector;

  private Provider<NavigationController> navigationControllerProvider;

  private MembersInjector<MainControllerImpl> mainControllerImplMembersInjector;

  private DaggerMainAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideMainControllerProvider =
        MainControllerModule_ProvideMainControllerFactory.create(builder.mainControllerModule);

    this.headerControllerProvider =
        HeaderController_Factory.create(
            MembersInjectors.<HeaderController>noOp(), provideMainControllerProvider);

    this.yellowControllerProvider =
        YellowController_Factory.create(
            MembersInjectors.<YellowController>noOp(), provideMainControllerProvider);

    this.redControllerProvider =
        RedController_Factory.create(
            MembersInjectors.<RedController>noOp(), provideMainControllerProvider);

    this.greenControllerProvider =
        GreenController_Factory.create(
            MembersInjectors.<GreenController>noOp(), provideMainControllerProvider);

    this.navigationControllerMembersInjector =
        NavigationController_MembersInjector.create(
            yellowControllerProvider, redControllerProvider, greenControllerProvider);

    this.navigationControllerProvider =
        NavigationController_Factory.create(
            navigationControllerMembersInjector, provideMainControllerProvider);

    this.mainControllerImplMembersInjector =
        MainControllerImpl_MembersInjector.create(
            headerControllerProvider, navigationControllerProvider);
  }

  @Override
  public void inject(MainControllerImpl mainController) {
    mainControllerImplMembersInjector.injectMembers(mainController);
  }

  @Override
  public void inject(NavigationController navigationController) {
    navigationControllerMembersInjector.injectMembers(navigationController);
  }

  public static final class Builder {
    private MainControllerModule mainControllerModule;

    private Builder() {}

    public MainAppComponent build() {
      if (mainControllerModule == null) {
        throw new IllegalStateException(
            MainControllerModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerMainAppComponent(this);
    }

    public Builder mainControllerModule(MainControllerModule mainControllerModule) {
      this.mainControllerModule = Preconditions.checkNotNull(mainControllerModule);
      return this;
    }
  }
}
