class Smartphone {
    private String modelo;
    private String fabricante;
    private String sistemaOperacional;

    public Smartphone(String modelo, String fabricante, String sistemaOperacional) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.sistemaOperacional = sistemaOperacional;
    }

    public void fazerChamada(String numero) {
        System.out.println("Chamando " + numero + "...");
    }

    public void enviarMensagem(String numero, String mensagem) {
        System.out.println("Enviando mensagem para " + numero + ": " + mensagem);
    }

    public void instalarAplicativo(Aplicativo aplicativo) {
        System.out.println("Instalando aplicativo: " + aplicativo.getNome());
    }

    public void usarSiri(String comando) {
        System.out.println("Usando Siri para: " + comando);
    }
}

class Aplicativo {
    private String nome;
    private String versao;

    public Aplicativo(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void abrir() {
        System.out.println("Abrindo aplicativo: " + nome);
    }

    public void fechar() {
        System.out.println("Fechando aplicativo: " + nome);
    }
}

class Camera {
    private int megapixels;
    private boolean modoRetrato;

    public Camera(int megapixels, boolean modoRetrato) {
        this.megapixels = megapixels;
        this.modoRetrato = modoRetrato;
    }

    public void tirarFoto() {
        if (modoRetrato) {
            System.out.println("Tirando foto em modo retrato com " + megapixels + " megapixels.");
        } else {
            System.out.println("Tirando foto com " + megapixels + " megapixels.");
        }
    }

    public void gravarVideo(int duracao) {
        System.out.println("Gravando vídeo de " + duracao + " segundos.");
    }
}

class ReconhecimentoFacial {
    public boolean reconhecerUsuario() {
        // Simulação de reconhecimento facial
        System.out.println("Reconhecendo usuário...");
        return true; // Retorna verdadeiro se o usuário for reconhecido
    }
} 