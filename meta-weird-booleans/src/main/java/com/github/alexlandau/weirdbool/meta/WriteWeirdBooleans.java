package com.github.alexlandau.weirdbool.meta;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteWeirdBooleans {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Expected exactly one argument, a path to the location to which the " +
                    "WeirdBooleans class is to be written");
        }
        String destPath = args[0];
        File destFile = new File(destPath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        if (!destFile.getParentFile().isDirectory()) {
            throw new IllegalStateException("The parent path " + destFile.getParent() + " of the destination is not a " +
                    "directory, and a directory could not be created in that location");
        }

        writeClassToFile(destFile);
    }

    private static void writeClassToFile(File destFile) throws IOException {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(52, Opcodes.ACC_PUBLIC | Opcodes.ACC_FINAL | Opcodes.ACC_SUPER, "com/github/alexlandau/weirdbool/WeirdBooleans", null, "java/lang/Object", null);
        {
            // Add the private constructor
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PRIVATE, "<init>", "()V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add injectFalse
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "injectFalse", "(Lcom/github/alexlandau/weirdbool/BooleanConsumer;)V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "com/github/alexlandau/weirdbool/BooleanConsumer", "accept", "(Z)V", true);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add injectTrue
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "injectTrue", "(Lcom/github/alexlandau/weirdbool/BooleanConsumer;)V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "com/github/alexlandau/weirdbool/BooleanConsumer", "accept", "(Z)V", true);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add injectTralse
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "injectTralse", "(Lcom/github/alexlandau/weirdbool/BooleanConsumer;)V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_2);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "com/github/alexlandau/weirdbool/BooleanConsumer", "accept", "(Z)V", true);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add injectThrue
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "injectThrue", "(Lcom/github/alexlandau/weirdbool/BooleanConsumer;)V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_3);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "com/github/alexlandau/weirdbool/BooleanConsumer", "accept", "(Z)V", true);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add injectFralse
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "injectFralse", "(Lcom/github/alexlandau/weirdbool/BooleanConsumer;)V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitInsn(Opcodes.ICONST_4);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEINTERFACE, "com/github/alexlandau/weirdbool/BooleanConsumer", "accept", "(Z)V", true);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        {
            // Add printBooleanAsInt
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "boolToInt", "(Z)I", null, null);
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 0);
            methodVisitor.visitInsn(Opcodes.IRETURN);
            methodVisitor.visitMaxs(-1, -1); // Autocomputed due to COMPUTE_FRAMES; args are ignored
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        Files.write(destFile.toPath(), classWriter.toByteArray());
    }
}
