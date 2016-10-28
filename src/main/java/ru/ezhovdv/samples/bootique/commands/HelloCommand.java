package ru.ezhovdv.samples.bootique.commands;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.Provider;

import io.bootique.cli.Cli;
import io.bootique.command.Command;
import io.bootique.command.CommandOutcome;
import io.bootique.jersey.client.HttpClientFactory;

public class HelloCommand implements Command {
	@Inject
	private Provider<HttpClientFactory> provider;

	@Override
	public CommandOutcome run(final Cli arg0) {
		final Client client = provider.get().newAuthenticatedClient("twitter");
		final Response response = client.target("https://api.twitter.com/1.1/search/tweets.json")
				.queryParam("q", "BootiqueProject").request().get();
		System.out.println(response.readEntity(String.class));
		return CommandOutcome.succeeded();
	}

}
