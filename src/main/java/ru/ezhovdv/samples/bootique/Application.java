package ru.ezhovdv.samples.bootique;

import com.google.inject.Binder;
import com.google.inject.Module;

import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.jersey.JerseyModule;
import ru.ezhovdv.samples.bootique.commands.HelloCommand;
import ru.ezhovdv.samples.bootique.resources.HelloResource;

public class Application implements Module {

	public static void main(final String[] args) {
		Bootique.app(args).autoLoadModules().module(Application.class).run();
	}

	@Override
	public void configure(final Binder binder) {
		BQCoreModule.contributeCommands(binder).addBinding().to(HelloCommand.class);
		JerseyModule.contributeResources(binder).addBinding().to(HelloResource.class);
	}
}
