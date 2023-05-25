# next-gen-java-openwhisk-runtime

This repo is used to store some experiments for creating a next generation Java runtime for the OpenWhisk framework based on my experience proposing changes to the Java runtime in the OpenWhisk project and on creating my own updated runtimes based on my proposed changes.

This project is going to explore going even further than what was achieved in my Java 19 runtime:

* How to allow the user to define their own classes/records to use for the parameter type, so that they don't have to use low level Gson classes or Map data structures.
* How to allow the user to use extensions of abstract classes, implementations of interfaces, or annotations to get more guidance in the Java code they write, and to increase the chance of them creating code compatible with the OpenWhisk framework the first time.

Notably, ChatGPT 4 will be leveraged as a coding partner to help me explore these ideas.

## Progress

### 1 - User defined classes

The directory `1_user_defined_classes` demonstrates that users can create their own classes that the OpenWhisk framework can deserialize the arguments into.

ChatGPT 4 helped me discover and create this. The ChatGPT conversation is included in that directory for reference.
