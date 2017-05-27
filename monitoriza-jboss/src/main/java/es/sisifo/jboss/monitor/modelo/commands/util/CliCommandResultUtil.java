package es.sisifo.jboss.monitor.modelo.commands.util;

import java.util.ArrayList;
import java.util.List;

import org.jboss.as.cli.scriptsupport.CLI.Result;
import org.jboss.dmr.ModelNode;

public class CliCommandResultUtil {
	private CliCommandResultUtil(){}

	public static List<String> parseListResult(final Result result) {
		final List<ModelNode> nodeNamesModel = result.getResponse().get("result").asList();

		final List<String> nodeNames = new ArrayList<>();
		for (final ModelNode modelNode : nodeNamesModel) {
			nodeNames.add(modelNode.asString());
		}
		return nodeNames;
	}
}
