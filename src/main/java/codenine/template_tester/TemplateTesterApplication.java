package codenine.template_tester;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TemplateTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateTesterApplication.class, args);
	}

	//서버 시작 시 등록
//	@Bean
//	CommandLineRunner run(MemberRepository memberRepository) {
//		return args -> {
//			memberRepository.save(new Member("sohyun"));
//			System.out.println("Member saved!");
//		};
//	}

}
