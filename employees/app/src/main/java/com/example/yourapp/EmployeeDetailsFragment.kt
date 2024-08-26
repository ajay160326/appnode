package com.example.yourapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class EmployeeDetailsFragment : Fragment() {

    private lateinit var editTextName: EditText
    private lateinit var editTextPosition: EditText
    private lateinit var editTextDepartment: EditText
    private lateinit var editTextExpectations: EditText
    private lateinit var buttonAddEmployee: Button
    private lateinit var listViewEmployees: ListView

    private lateinit var viewModel: EmployeeViewModel
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employee_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(EmployeeViewModel::class.java)

        // Initialize Views
        editTextName = view.findViewById(R.id.editTextName)
        editTextPosition = view.findViewById(R.id.editTextPosition)
        editTextDepartment = view.findViewById(R.id.editTextDepartment)
        editTextExpectations = view.findViewById(R.id.editTextExpectations)
        buttonAddEmployee = view.findViewById(R.id.buttonAddEmployee)
        listViewEmployees = view.findViewById(R.id.listViewEmployees)

        // Setup ListView Adapter
        adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, mutableListOf<String>())
        listViewEmployees.adapter = adapter

        // Observe the employee list and update the ListView
        viewModel.employees.observe(viewLifecycleOwner, { employees ->
            adapter.clear()
            for (employee in employees) {
                adapter.add("${employee.name} - ${employee.position} - ${employee.department}")
            }
            adapter.notifyDataSetChanged()
        })

        // Handle Add Employee Button Click
        buttonAddEmployee.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val position = editTextPosition.text.toString().trim()
            val department = editTextDepartment.text.toString().trim()
            val expectations = editTextExpectations.text.toString().trim()

            if (name.isNotEmpty() && position.isNotEmpty() && department.isNotEmpty()) {
                val employee = Employee(name, position, department, expectations)
                viewModel.addEmployee(employee)
                // Clear input fields
                editTextName.text.clear()
                editTextPosition.text.clear()
                editTextDepartment.text.clear()
                editTextExpectations.text.clear()
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
