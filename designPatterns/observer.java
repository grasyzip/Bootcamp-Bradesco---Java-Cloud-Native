@Component
public class MeuEvento extends ApplicationEvent {
    public MeuEvento(Object source) {
        super(source);
    }
}

@Component
public class PublicadorDeEventos {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publicarEvento(String mensagem) {
        eventPublisher.publishEvent(new MeuEvento(mensagem));
    }
}

@Component
public class OuvinteDeEventos implements ApplicationListener<MeuEvento> {
    @Override
    public void onApplicationEvent(MeuEvento evento) {
        System.out.println("Evento recebido: " + evento.getSource());
    }
}
