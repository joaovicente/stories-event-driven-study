package io.github.joaovicente.stories;

import com.uber.jaeger.samplers.ProbabilisticSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.uber.jaeger.Configuration;

@SpringBootApplication
public class StoriesApplication {

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("spring-boot",
				new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();
	}

	public static void main(String[] args) {
		SpringApplication.run(StoriesApplication.class, args);
	}
}
