
<h3>Resumo:</h3>
<h6>Vector: É uma classe que implementa uma matriz dinâmica de objetos que aumenta de tamanho à medida que novos elementos são adicionados. É uma versão sincronizada do ArrayList.</h6>
<h6>ArrayList: É uma classe que implementa uma matriz dinâmica de objetos, permitindo o armazenamento de elementos duplicados. É não sincronizado, o que significa que não é seguro para uso em threads concorrentes.</h6>
<h6>LinkedList: É uma implementação de lista duplamente encadeada. Cada elemento na lista é um nó que contém uma referência tanto para o elemento anterior quanto para o próximo na sequência. É útil quando se precisa de inserção ou remoção frequentes em posições intermediárias da lista.</h6>
<h6>HashMap: É uma implementação da interface Map que armazena dados na forma de pares chave-valor. É baseado no princípio de hash table, onde os elementos são armazenados em buckets com base nos seus hashes.</h6>
<h3>Características:</h3>
<h6>Vector: Sincronizado, pode ser lento devido à sincronização, permite acesso rápido aos elementos por meio de índices.</h6>
<h6>ArrayList: Não sincronizado, rápido para acessar elementos por índices, mas mais lento para inserções e remoções no meio da lista.</h6>
<h6>LinkedList: Eficiente para inserção e remoção de elementos no meio da lista, mas menos eficiente para acesso aleatório aos elementos.</h6>
<h6>HashMap: Eficiente para inserção, remoção e busca de elementos por chave, mas não mantém a ordem dos elementos.</h6>
<h3>Exemplos:</h3>
<h6>Vector: Toda vez que um novo item chega, a fila é aumentada em uma posição para acomodar o novo item.</h6>
<h6>ArrayList: À medida que você coloca mais items, a fila aumenta de tamanho para armazenar todos eles.</h6>
<h6>LinkedList: Se você quiser adicionar um novo item no meio da lista, basta conectá-lo aos items adjacentes.</h6>
<h6>HashMap: Você pode procurar rapidamente chave sem precisar percorrer toda a lista. Cada palavra está associada a um significado (valor) por meio de uma chave única.</h6>
